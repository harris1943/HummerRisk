<template>
  <div @click="validate(row)">
    <el-tag size="mini" type="warning" v-if="row.status === 'DELETE'">
    {{ $t('server.DELETE') }}
    </el-tag>
    <el-tag size="mini" type="success" v-else-if="row.status === 'VALID'">
      {{ $t('server.VALID') }}
    </el-tag>
    <el-tag size="mini" type="danger" v-else-if="row.status === 'INVALID'">
      {{ $t('server.INVALID') }}
    </el-tag>
  </div>
</template>

<script>
  /* eslint-disable */
  export default {
    name: "ServerStatus",
    inject:['search'],
    props: {
      row: Object
    },
    methods: {
      validate(row) {
        this.$alert(this.$t('server.validate') + this.$t('server.server_status') + ' : ' + row.name +  " ？", '', {
          confirmButtonText: this.$t('commons.confirm'),
          callback: (action) => {
            if (action === 'confirm') {
              this.$post("/server/validate/" + row.id, {}, response => {
                if (response.data) {
                  this.$success(this.$t('server.success'));
                  this.search();
                } else {
                  this.$error(this.$t('server.error'));
                }
              });
            }
          }
        });
      },
    }
  }
</script>

<style scoped>

</style>
